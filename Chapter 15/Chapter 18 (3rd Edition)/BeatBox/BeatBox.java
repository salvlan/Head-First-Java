import javax.swing.*;
import javax.swing.event.*;
import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class BeatBox {

    JFrame theFrame;
    JPanel mainPanel;
    JList incomingList;
    JTextField userMessage;
    ArrayList<JCheckBox> checkboxList;
    int nextNum;
    Vector<String> listVector = new Vector<String>();
    String userName;
    ObjectOutputStream out;
    ObjectInputStream in;
    HashMap<String, boolean[]> otherSeqsMap = new HashMap<>();

    Sequencer sequencer;
    Sequence sequence;
    Sequence mySequence = null;
    Track track;

    String [] instrumentNames = {"BassDrum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "High Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56,58,47, 67,63};

    public static void main(String[] args) {
        new BeatBox().startUp(args[0]); // args[0] is your user ID/screen name (add a command-line argument for your screen name, ex: % java BeatBox theFlash)
    }

    public void startUp (String name){
        userName = name;
        try{
            Socket sock = new Socket("127.0.0.1", 4242);
            out = new ObjectOutputStream(sock.getOutputStream());
            in = new ObjectInputStream(sock.getInputStream());
            Thread remote = new Thread(new RemoteReader());
            remote.start();
        } catch (Exception ex){
            ex.printStackTrace();
            System.out.println("couldn't connect - you'll have to play alone.");
        }
        setUpMidi();
        buildGUI();
    }

    public void buildGUI(){

        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        checkboxList = new ArrayList<>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e->buildTrackAndStart());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(e->sequencer.stop());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(e->changeTempo(1.03f));
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(e ->changeTempo(0.97f));
        buttonBox.add(downTempo);

        JButton sendIt = new JButton("sendIt");
        sendIt.addActionListener(e->sendMessageAndTracks());
        buttonBox.add(sendIt);

        //new buttons "beginning"
        JButton save = new JButton("Save");
        save.addActionListener(e->{
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(theFrame);
            saveFile(fileSave.getSelectedFile());
        });
        buttonBox.add(save);

        JButton load = new JButton("Load");
        load.addActionListener(e->{
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(theFrame);
            loadFile(fileOpen.getSelectedFile());
        });
        buttonBox.add(load);
        //new buttons "end"

        userMessage = new JTextField();
        buttonBox.add(userMessage);

        incomingList = new JList();
        incomingList.addListSelectionListener(new MyListSelectionListener());
        incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane theList = new JScrollPane(incomingList);
        buttonBox.add(theList);
        incomingList.setListData(listVector);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i=0;i<16;i++){
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST,buttonBox);
        background.add(BorderLayout.WEST,nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i<256;i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void setUpMidi(){
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart (){

        ArrayList<Integer> trackList = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i=0;i<16;i++){
            trackList = new ArrayList<Integer>();

            for (int j=0;j<16;j++){

                JCheckBox jc = (JCheckBox) checkboxList.get(j+(16*i));
                if(jc.isSelected()){
                    int key = instruments[i];
                    trackList.add(key);
                } else {
                    trackList.add(null);
                }
            }

            makeTracks(trackList);
        }

        track.add(makeEvent(192,9,1,0,15));

        try{
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void changeTempo(float tempoMultiplier) {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
    }

    //local save&load section "beginning"
    private void saveFile (File file){
        boolean[] checkboxState = new boolean[256];
        for ( int i=0; i<256; i++){
            JCheckBox check = checkboxList.get(i);
            if (check.isSelected()){
                checkboxState[i] = true;
            }
        }
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
            os.writeObject(checkboxState);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void loadFile (File file){
        boolean[] checkboxState = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream (file))) {
            checkboxState = (boolean[]) is.readObject();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        for ( int i=0; i<256; i++){
            JCheckBox check = checkboxList.get(i);
            if (checkboxState[i]){
                check.setSelected(true);
            } else {
                check.setSelected(false);
            }
        }
        sequencer.stop();
        buildTrackAndStart();
    }
    //local save&load section "end"

    private void sendMessageAndTracks() {
        boolean[] checkboxState = new boolean[256];
        for (int i = 0; i < 256; i++) {
            JCheckBox check = checkboxList.get(i);
            if (check.isSelected()) {
                checkboxState[i] = true;
            }
        }
        try {
            out.writeObject(userName + nextNum++ + ": " + userMessage.getText());
            out.writeObject(checkboxState);
        } catch (IOException e) {
            System.out.println("Sorry dude. Could not send it to the server.");
            e.printStackTrace();
        }
        userMessage.setText("");
    }

    public class MyListSelectionListener implements ListSelectionListener{
        public void valueChanged (ListSelectionEvent le){
            if(!le.getValueIsAdjusting()){
                String selected = (String) incomingList.getSelectedValue();
                if(selected != null){
                    boolean[] selectedState = otherSeqsMap.get(selected);
                    changeSequence(selectedState);
                    sequencer.stop();
                    buildTrackAndStart();
                }
            }
        }
    }

    public class RemoteReader implements Runnable {
        boolean[] checkboxState = null;
        Object obj = null;

        public void run(){
            try{
                while ( (obj=in.readObject()) != null){
                    System.out.println("Got an object from server");
                    System.out.println(obj.getClass());
                    String nameToShow = (String) obj;
                    checkboxState = (boolean[]) in.readObject();
                    otherSeqsMap.put(nameToShow, checkboxState);
                    listVector.add(nameToShow);
                    incomingList.setListData(listVector);
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public class MyPlayMineListener implements ActionListener{
        public void actionPerformed (ActionEvent a){
            if(mySequence != null){
                sequence = mySequence; //restore to my original
            }
        }
    }

    public void changeSequence (boolean[] checkboxState) {
        for(int i=0; i<256; i++){
            JCheckBox check = checkboxList.get(i);
            if(checkboxState[i]){
                check.setSelected(true);
            } else {
                check.setSelected(false);
            }
        }
    }

    public void makeTracks (ArrayList list){
        Iterator it = list.iterator();

        for(int i=0;i<16;i++){
            Integer num = (Integer) it.next();
            if (num != null){
                int numKey = num.intValue();
                track.add(makeEvent(144,9,numKey,100,i));
                track.add(makeEvent(128,9,numKey,100,i+1));
            }
        }

    }

    public MidiEvent makeEvent (int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event = new MidiEvent(a,tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

}
