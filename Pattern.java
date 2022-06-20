import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Pattern extends JFrame implements ActionListener {

    private int[] n;
    private int c;
    private int v;
    private int time;

    private Random rand;

    private JLabel t;
    private JButton[] box;
    private JButton b1, b2;
    private JPanel p1, p2, p3, p4;


    public Pattern() {
        setLayout(new GridLayout(5,1));

        n = new int[5];
        rand = new Random();
        c = 0;
        time = 175;


        t = new JLabel("Welcome!", JLabel.CENTER);
        t.setFont(new Font("Serif", Font.BOLD, 30));
        add(t);

        box = new JButton[9];
        for (int i=0; i<9; i++)
        {
            box[i] = new JButton();
            box[i].setOpaque(true);
            box[i].addActionListener(this);
            box[i].setBackground(Color.white);
        }

        p1 = new JPanel(new GridLayout(1,3));
        p1.add(box[0]);
        p1.add(box[1]);
        p1.add(box[2]);
        add(p1);

        p2 = new JPanel(new GridLayout(1,3));
        p2.add(box[3]);
        p2.add(box[4]);
        p2.add(box[5]);
        add(p2);

        p3 = new JPanel(new GridLayout(1,3));
        p3.add(box[6]);
        p3.add(box[7]);
        p3.add(box[8]);
        add(p3);

        p4 = new JPanel(new GridLayout(1,2));
        b1 = new JButton("Start");
        b1.setFont(new Font("Serif", Font.PLAIN, 24));
        b1.setOpaque(true);
        b1.setBackground(Color.white);
        b1.addActionListener(this);
        b2 = new JButton("Finish");
        b2.setFont(new Font("Serif", Font.PLAIN, 24));
        b2.setOpaque(true);
        b2.setBackground(Color.white);
        b2.addActionListener(this);
        p4.add(b1);
        p4.add(b2);
        add(p4);
    }
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b2)
        {
            System.exit(0);
        }
        if (e.getSource()==b1)
        {
            c=0;
            start();
            b1.setEnabled(false);
            b2.setEnabled(false);
        }
        else
        {
            v = n[c];
            if (e.getSource()==box[v])
            {
                c++;
                t.setText("Correct! " + c + "/5" );
                if (c>4)
                {
                    t.setText("Congrats! " + c + "/5" );
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    for (int i=0; i<9; i++)
                    {
                        box[i].setEnabled(false);
                    }
                }
            }
            else
            {
                t.setText("Incorrect. You Lose!");
                for (int i=0; i<9; i++)
                {
                    box[i].setEnabled(false);
                }
                b1.setEnabled(true);
                b2.setEnabled(true);
            }
        }
    }

    public void start(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() throws Exception {
                b1.setText("Play Again?");
                t.setText("3");
                Thread.sleep(1000);
                t.setText("2");
                Thread.sleep(1000);
                t.setText("1");
                Thread.sleep(1000);
                t.setText("GO!");
                b1.setEnabled(false);
                b2.setEnabled(false);
                for (int i=0; i<9; i++)
                {
                    box[i].setEnabled(true);
                }
                for (int i=0; i<5; i++)
                {
                    v = rand.nextInt(9);
                    n[i] = v;
                    Thread.sleep(time);
                    box[v].setBackground(Color.BLACK);
                    Thread.sleep(time);
                    box[v].setBackground(Color.white);
                }
                return null;
            }

        };
        worker.execute();
    }
}



