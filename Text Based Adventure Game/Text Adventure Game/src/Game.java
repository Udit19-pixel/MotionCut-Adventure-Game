import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game
{
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;

    Font titleFont=new Font("Calibre",Font.PLAIN,42);
    Font normalText=new Font("Times New Roman",Font.PLAIN,28);
    JButton startButton,choice1,choice2,choice3,choice4;
    JTextArea mainTextArea;

    int playerHP, monsterHP, silverRing;
    String weapon, position;
    TitleScreenHandler tHandler=new TitleScreenHandler();
    choiceHandler cHandler=new choiceHandler();

    public static void main(String[] args)
    {
        new Game();
    }

    public Game()
    {
        window=new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con=window.getContentPane();

        titleNamePanel=new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel=new JLabel("FOREST FIGHT");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel=new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);

        startButton=new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalText);
        startButton.addActionListener(tHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        
        window.setVisible(true);
    }

    public void createGameScreen()
    {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel=new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea=new JTextArea("Dialog section");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalText);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel=new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1=new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("C1");

        choice2=new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("C2");

        choice3=new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("C3");

        choice4=new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("C4");

        playerPanel=new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel=new JLabel("HP:-");
        hpLabel.setFont(normalText);
        hpLabel.setForeground(Color.white);

        playerPanel.add(hpLabel);

        hpLabelNumber=new JLabel();
        hpLabelNumber.setFont(normalText);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel=new JLabel("Weapon:-");
        weaponLabel.setFont(normalText);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName=new JLabel();
        weaponLabelName.setFont(normalText);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();
    }

    public void playerSetup()
    {
        playerHP=15;
        monsterHP=20;
        weapon="Knife";
        weaponLabelName.setText(" "+weapon);
        hpLabelNumber.setText(" "+playerHP);

        townGate();
    }

    public void townGate()
    {
        position="Town Gate";
        mainTextArea.setText("You are at the gate of the town.\nA guard is standing in front of you.\n\nWhat do you do?");

        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkGuard()
    {
        position="Talk Guard";
        mainTextArea.setText("Guard: Hello, I have never seen you here.\nI'm sorry but we cannot let a stranger enter the town");

        choice1.setText("->");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard()
    {
        position="Attack Guard";
        mainTextArea.setText("Guard: Hey, don't be stupid!\n\nThe guard fought back and hit you.\nYou received 3 damage.");
        playerHP=playerHP-3;
        hpLabelNumber.setText(" "+playerHP);

        choice1.setText("->");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad()
    {
        position="Cross Road";
        mainTextArea.setText("You are at a crossroad.\nGo South to go back to the town.");

        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go West");
    }

    public void North()
    {
        position="North";
        mainTextArea.setText("You found a river.\nYou drink water and rest along the river.\nYour HP was recovered by 2");
        playerHP=playerHP+2;
        hpLabelNumber.setText(" "+playerHP);

        choice1.setText("Go South");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    public void East()
    {
        position="East";
        mainTextArea.setText("You walked into a forest and found a chest having a Long Sword inside it.\n(You obtained the Long Sword.)");
        weapon="Long Sword";
        weaponLabelName.setText(weapon);

        choice1.setText("Go West");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void West()
    {
        position="West";
        monsterHP=20;
        mainTextArea.setText("You encounter a Goblin.");

        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void fight()
    {
        position="Fight";
        mainTextArea.setText("Monster HP:-"+monsterHP+"\n(What do you do?)");

        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void playerAttack()
    {
        position="Player Attack";
        int playerDamage=0;
        if (weapon.equals("Knife"))
        {
            playerDamage=new java.util.Random().nextInt(3);
        }
        else if (weapon.equals("Long Sword"))
        {
            playerDamage=new java.util.Random().nextInt(12);
        }
        mainTextArea.setText("You attacked the monster and gave "+playerDamage+" damage!");
        monsterHP=monsterHP-playerDamage;

        choice1.setText("->");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void monsterAttack()
    {
        position="Monster Attack";
        int monsterDamage;
        monsterDamage=new java.util.Random().nextInt(6);
        mainTextArea.setText("The monster attacked you and gave "+monsterDamage+" damage!");
        playerHP=playerHP-monsterDamage;
        hpLabelNumber.setText(" "+playerHP);

        choice1.setText("->");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void win()
    {
        position="Win";
        mainTextArea.setText("You defeated the monster!\nMonster dropped a ring.\n(Obtained a Silver ring)");
        silverRing=1;

        choice1.setText("Go East");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void lose()
    {
        position="Lose";
        mainTextArea.setText("You are dead!\nGame Over");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void ending()
    {
        position="Ending";
        mainTextArea.setText("Guard: Oh you killed the Goblin!\nThank you!\nYou are a warrior\nWelcome to the town\n\nThe End");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public class TitleScreenHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            createGameScreen();
        }
    }

    public class choiceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String yourChoice=event.getActionCommand();
            switch (position)
            {
                case "Town Gate" ->
                {
                    switch (yourChoice)
                    {
                        case "C1" ->
                        {
                            if (silverRing == 1)
                            {
                                ending();
                            }
                            else
                            {
                                talkGuard();
                            }
                        }
                        case "C2" -> attackGuard();
                        case "C3" -> crossRoad();
                    }
                }
                case "Talk Guard", "Attack Guard" ->
                {
                    if (yourChoice.equals("C1"))
                    {
                        townGate();
                    }
                }
                case "Cross Road" ->
                {
                    switch (yourChoice)
                    {
                        case "C1" -> North();
                        case "C2" -> East();
                        case "C3" -> townGate();
                        case "C4" -> West();
                    }
                }
                case "North", "East", "Win" ->
                {
                    if (yourChoice.equals("C1"))
                    {
                        crossRoad();
                    }
                }
                case "West" ->
                {
                    switch (yourChoice)
                    {
                        case "C1" -> fight();
                        case "C2" -> crossRoad();
                    }
                }
                case "Fight" ->
                {
                    switch (yourChoice)
                    {
                        case "C1" -> playerAttack();
                        case "C2" -> crossRoad();
                    }
                }
                case "Player Attack" ->
                {
                    if (yourChoice.equals("C1"))
                    {
                        if (monsterHP < 1)
                        {
                            win();
                        }
                        else
                        {
                            monsterAttack();
                        }
                    }
                }
                case "Monster Attack" ->
                {
                    switch (yourChoice)
                    {
                        case "C1": if (playerHP < 1)
                                   {
                                       lose();
                                   }
                                   else
                                   {
                                       fight();
                                   }
                                   break;
                        case "C2", "C3", "C4": break;
                    }
                }
            }
        }
    }
}