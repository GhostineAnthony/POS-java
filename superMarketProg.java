import javax.print.Doc;
import javax.print.FlavorException;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
//import java.text.BreakIterator;

public class superMarketProg {
    public static void main(String[] args) {

        new signUp(null, "login", true);
    }
}

/*
 * class firstScreen extends JFrame{
 * JFrame frame = new JFrame();
 * firstScreen(){
 * frame.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),
 * (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
 * frame.setResizable(false);
 * frame.setTitle("supermarket Programe");
 * frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 * frame.setLocationRelativeTo(null);
 * 
 * new signUp(null,"sign up",true);
 * }
 * public void visible(){
 * frame.setVisible(true);
 * }
 * public void close(){
 * frame.setVisible(false);
 * }
 * }
 */
class signUp extends JDialog {
    private JPanel panel = new JPanel();
    private JLabel lbl_name = new JLabel("Name");
    private JLabel lbl_password = new JLabel("password");
    private JTextField txt_name = new JTextField(10);
    private JTextField txt_password = new JTextField(10);
    private JButton btn_login = new JButton("Login");
    private JButton btn_signup = new JButton("Sign up");
    JFrame frame = new JFrame();

    signUp(JFrame parent, String titre, boolean module) {
        super(parent, titre, module);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_name.setBounds(45, 30, 100, 20);
        txt_name.setBounds(130, 30, 100, 20);

        lbl_password.setBounds(45, 70, 100, 20);
        txt_password.setBounds(130, 70, 100, 20);

        btn_login.setBounds(45, 110, 80, 20);
        btn_signup.setBounds(150, 110, 80, 20);

        panel.setLayout(null);

        panel.add(lbl_name);
        panel.add(txt_name);

        panel.add(lbl_password);
        panel.add(txt_password);

        panel.add(btn_login);
        panel.add(btn_signup);

        this.getRootPane().setDefaultButton(btn_login);

        btn_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String name = String.valueOf(txt_name.getText());
                String pass = String.valueOf(txt_password.getText());
                // if(name=="A" && pass=="1"){.getRootPane().setDefaultButton(button);
                frame.setVisible(false);
                new programe();
            }
            // }
        });

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}

class programe extends JFrame implements ActionListener {
    private JPanel container = new JPanel();
    private JPanel favPanel = new JPanel();
    private JPanel catPanel = new JPanel();
    private JPanel buyRetourPanel = new JPanel();
    private JPanel cat1Panel = new JPanel();
    private JPanel cat2Panel = new JPanel();
    private JPanel cat3Panel = new JPanel();
    private JPanel cat4Panel = new JPanel();
    private JPanel cat5Panel = new JPanel();
    private JPanel cat6Panel = new JPanel();
    private JButton fav, cat1, cat2, cat3, cat4, cat5, cat6;
    private JButton buybtn, retourbtn;
    private JOptionPane jop;
    private JMenuBar menubar = new JMenuBar();
    private JMenu file = new JMenu("file");
    private JMenuItem edit = new JMenuItem("Edit");
    private JMenuItem home = new JMenuItem("Home");
    private JMenuItem settings = new JMenuItem("settings");
    private JMenuItem exit = new JMenuItem("Exit");
    private JTextArea txtArea = new JTextArea(50, 30);
    private JTextArea txtAreaSum = new JTextArea(10, 30);
    private String role;
    String btnFav = "fav";
    String cat1item = "cat1 item";
    String cat2item = "cat2 item";
    String cat3item = "cat3 item";
    String cat4item = "cat4 item";
    String cat5item = "cat5 item";
    String cat6item = "cat6 item";
    JButton[] btnArray = new JButton[42];
    JButton[] btncat1Array = new JButton[42];
    JButton[] btncat2Array = new JButton[42];
    JButton[] btncat3Array = new JButton[42];
    JButton[] btncat4Array = new JButton[42];
    JButton[] btncat5Array = new JButton[42];
    JButton[] btncat6Array = new JButton[42];
    float totPrice = 0;
    float price = 0;
    float dollar_rate = 1500;
    JButton[] btncategorieArray = { fav, cat1, cat2, cat3, cat4, cat5, cat6 };
    JPanel[] panelCategorieArray = { favPanel, cat1Panel, cat2Panel, cat3Panel, cat4Panel, cat5Panel, cat6Panel };

    programe() {
        // ---------JButton----------------------
        godButton(btnFav, btnArray);
        godButton(cat1item, btncat1Array);
        godButton(cat2item, btncat2Array);
        godButton(cat3item, btncat3Array);
        godButton(cat4item, btncat4Array);
        godButton(cat5item, btncat5Array);
        godButton(cat6item, btncat6Array);
        // ----------cat JButton-------------
        btncategorieArray[0] = new JButton("favorite");
        for (int i = 1; i <= btncategorieArray.length - 1; i++)
            btncategorieArray[i] = new JButton("categorie" + i);
        // -----------buy and retour JButton---------
        buybtn = new JButton("buy");
        retourbtn = new JButton("retour");

        /*
         * JPanel test = new JPanel();
         * test.setPreferredSize(new Dimension( 2000,2000));
         * JScrollPane scrollFrame = new JScrollPane(test);
         * test.setAutoscrolls(true);
         * scrollFrame.setPreferredSize(new Dimension( 800,300));
         * this.add(scrollFrame);
         */

        // ------------JFrame-----------------------
        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        this.setResizable(false);
        this.setTitle("supermarket Programe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // ---------txtArea------------------------
        txtArea.setBounds(1100, 40, 200, 500);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setEditable(false);
        // --------txtAreaSum------------------------
        txtAreaSum.setBounds(1100, 540, 200, 100);
        txtAreaSum.setLineWrap(true);
        txtAreaSum.setWrapStyleWord(true);
        txtAreaSum.setEditable(false);
        // -------favPanel----------------------
        this.favPanel.setSize(800, 600);
        this.favPanel.setLocation(150, 40);
        this.favPanel.setLayout(new GridLayout(7, 6));
        // this.favPanel.setBackground(new Color(255,0,0));
        // -------buyRetourPanel---------------
        this.buyRetourPanel.setSize(100, 200);
        this.buyRetourPanel.setLocation(975, 440);
        this.buyRetourPanel.setLayout(new GridLayout(2, 1));
        // this.buyRetourPanel.setBackground(new Color(255,0,0));
        // ---------catNPanel-------------
        for (int i = 0; i <= panelCategorieArray.length - 1; i++) {
            this.panelCategorieArray[i].setSize(800, 600);
            this.panelCategorieArray[i].setLocation(150, 40);
            this.panelCategorieArray[i].setLayout(new GridLayout(7, 6));
        }
        // --------catPanel---------------------
        this.catPanel.setLocation(40, 40);
        this.catPanel.setLayout(new GridLayout(7, 1));
        this.catPanel.setSize(100, 600);
        // ---------adding btn to favPanel--------------
        for (int i = 0; i <= btnArray.length - 1; i++)
            this.favPanel.add(btnArray[i]);
        // -------adding button to catPanel----------
        for (int i = 0; i <= btncategorieArray.length - 1; i++)
            this.catPanel.add(btncategorieArray[i]);
        // ------adding button to catPanel------
        for (int i = 0; i <= btncat1Array.length - 1; i++)
            this.cat1Panel.add(btncat1Array[i]);
        for (int i = 0; i <= btncat2Array.length - 1; i++)
            this.cat2Panel.add(btncat2Array[i]);
        for (int i = 0; i <= btncat3Array.length - 1; i++)
            this.cat3Panel.add(btncat3Array[i]);
        for (int i = 0; i <= btncat4Array.length - 1; i++)
            this.cat4Panel.add(btncat4Array[i]);
        for (int i = 0; i <= btncat5Array.length - 1; i++)
            this.cat5Panel.add(btncat5Array[i]);
        for (int i = 0; i <= btncat6Array.length - 1; i++)
            this.cat6Panel.add(btncat6Array[i]);
        // ------adding btn to buyRetourPanel-------
        this.buyRetourPanel.add(retourbtn);
        this.buyRetourPanel.add(buybtn);
        // -------container---------------
        this.container.setLayout(null);
        for (int i = 0; i <= panelCategorieArray.length - 1; i++)
            this.container.add(panelCategorieArray[i]);
        this.container.add(txtArea);
        this.container.add(txtAreaSum);
        this.container.add(catPanel);
        this.container.add(buyRetourPanel);
        this.setContentPane(container);

        unVisiblePanel();
        visiblePanel(favPanel);
        changeButtonColor(Color.green);

        for (int i = 0; i <= btncategorieArray.length - 1; i++) {
            btncategorieArray[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    unVisiblePanel();
                    JButton button = (JButton) event.getSource();
                    for (int i = 0; i <= btncategorieArray.length - 1; i++) {
                        if (btncategorieArray[i] == button) {
                            visiblePanel(panelCategorieArray[i]);
                        }
                    }
                    /*
                     * if(role=="edit"){
                     * String option = jop.showInputDialog(null,"what you want to name the button"
                     * ,"change button name message",JOptionPane.QUESTION_MESSAGE);
                     * try{
                     * JButton buton = (JButton) event.getSource();
                     * if(option!=null && option!=""){
                     * buton.setText(option);
                     * }
                     * }
                     * catch(Exception e){}
                     * }
                     */
                }
            });
        }

        // ---------adding action listener to JButton--------------
        for (int i = 0; i <= btnArray.length - 1; i++)
            btnArray[i].addActionListener(this);
        for (int i = 0; i <= btncat1Array.length - 1; i++)
            btncat1Array[i].addActionListener(this);
        for (int i = 0; i <= btncat2Array.length - 1; i++)
            btncat2Array[i].addActionListener(this);
        for (int i = 0; i <= btncat3Array.length - 1; i++)
            btncat3Array[i].addActionListener(this);
        for (int i = 0; i <= btncat4Array.length - 1; i++)
            btncat4Array[i].addActionListener(this);
        for (int i = 0; i <= btncat5Array.length - 1; i++)
            btncat5Array[i].addActionListener(this);
        for (int i = 0; i <= btncat6Array.length - 1; i++)
            btncat6Array[i].addActionListener(this);

        retourbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (role != "retour") {
                    changeButtonColor(Color.red);
                    role = "retour";
                } else {
                    changeButtonColor(Color.green);
                    role = "home";
                }
            }

        });

        buybtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame f = new JFrame();
                zdialog zd = new zdialog(f, "titre", true, totPrice);

            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                role = "edit";
                changeButtonColor(Color.yellow);
                retourbtn.setVisible(false);
            }
        });

        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                role = "home";
                changeButtonColor(Color.green);
                retourbtn.setVisible(true);
            }
        });

        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                zdialog zd = new zdialog(null, "settings", true);
            }
        });

        this.file.add(home);
        this.file.add(edit);
        this.file.add(settings);
        this.file.add(exit);
        this.menubar.add(file);
        this.setJMenuBar(menubar);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        if (role == "edit") {
            String option = jop.showInputDialog(null, "What is the name of this item", "item name",
                    JOptionPane.QUESTION_MESSAGE);
            if (option != null && option != "") {
                String pricestr = jop.showInputDialog(null, "What is the item price?", "price value",
                        JOptionPane.QUESTION_MESSAGE);
                try {
                    price = Float.parseFloat(pricestr);
                    JButton button = (JButton) event.getSource();
                    button.setText("<html>" + option + "<br/>" + price + "</html>");
                } catch (NumberFormatException e) {
                    jop.showMessageDialog(null, "the price must be a number", "price error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            try {
                JButton button = (JButton) event.getSource();
                priceNote(button);
            } catch (Exception e) {
                jop.showMessageDialog(null, "This Item is empthy", "Empthy Item", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void changeButtonColor(Color c) {
        for (int i = 0; i <= btnArray.length - 1; i++)
            btnArray[i].setBackground(c);
        for (int i = 0; i <= btncat1Array.length - 1; i++)
            btncat1Array[i].setBackground(c);
        for (int i = 0; i <= btncat2Array.length - 1; i++)
            btncat2Array[i].setBackground(c);
        for (int i = 0; i <= btncat3Array.length - 1; i++)
            btncat3Array[i].setBackground(c);
        for (int i = 0; i <= btncat4Array.length - 1; i++)
            btncat4Array[i].setBackground(c);
        for (int i = 0; i <= btncat5Array.length - 1; i++)
            btncat5Array[i].setBackground(c);
        for (int i = 0; i <= btncat6Array.length - 1; i++)
            btncat6Array[i].setBackground(c);
    }

    public void visiblePanel(JPanel panel) {
        panel.setVisible(true);
    }

    public void unVisiblePanel() {
        favPanel.setVisible(false);
        cat1Panel.setVisible(false);
        cat2Panel.setVisible(false);
        cat3Panel.setVisible(false);
        cat4Panel.setVisible(false);
        cat5Panel.setVisible(false);
        cat6Panel.setVisible(false);
    }

    public void priceNote(JButton button) {
        String priceNote = button.getText();
        String[] name_price = priceNote.split("<br/>");
        String pricetxt = name_price[1].substring(0, name_price[1].indexOf("</html>"));
        String nametxt = name_price[0].substring(6);
        if (role == "home") {
            txtArea.append(nametxt + "\t" + pricetxt + "\n");
            totPrice += Float.parseFloat(pricetxt);
            txtAreaSum.setText("Item price \t" + pricetxt + "\nTotal\t" + totPrice);
            txtAreaSum.setFont(txtAreaSum.getFont().deriveFont(Font.BOLD));
        } else {
            txtArea.append(nametxt + "\t(" + pricetxt + ")\n");
            totPrice -= Float.parseFloat(pricetxt);
            txtAreaSum.setText("Item price \t-" + pricetxt + "\nTotal\t" + totPrice);
            txtAreaSum.setFont(txtAreaSum.getFont().deriveFont(Font.BOLD));
        }
        // txtAreaSum.setFont(textArea.getFont().deriveFont(Font.BOLD,
        // textArea.getFont().getSize()));
        // tPane.setMargin(new Insets(5, 5, 5, 5));
        // tPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        // use a JEditorPane or JTextPane
        // appendToPane(txtArea,"heelo", Color.RED);
    }

    public void godButton(String string, JButton[] buttonArray) {
        for (int i = 0; i <= 41; i++) {
            JButton button = new JButton(string + (i + 1));
            buttonArray[i] = button;
        }
    }

}

class zdialog extends JDialog {
    private JFrame frame = new JFrame();
    private JFrame frame2 = new JFrame();
    private JFrame frame3 = new JFrame();
    private JPanel pan = new JPanel();
    private JLabel lbl_lira = new JLabel("Lebanese Pound");
    private JLabel lbl_dollar = new JLabel("Dollar");
    private JLabel lbl_cash = new JLabel("Cash");
    private JLabel lbl_credit = new JLabel("Credit card");
    private JLabel lbl_check = new JLabel("Check");
    private JLabel lbl_still = new JLabel("Still");
    private JLabel lbl_change = new JLabel("Change");
    private JLabel lbl_dead_balance = new JLabel("Dead balance");
    private JTextField txt_credit_lira = new JTextField(10);
    private JTextField txt_credit_dollar = new JTextField(10);
    private JTextField txt_cash_lira = new JTextField(10);
    private JTextField txt_cash_dollar = new JTextField(10);
    private JTextField txt_check_lira = new JTextField(10);
    private JTextField txt_check_dollar = new JTextField(10);
    private JTextField txt_still_lira = new JTextField(10);
    private JTextField txt_still_dollar = new JTextField(10);
    private JTextField txt_change_lira = new JTextField(10);
    private JTextField txt_change_dollar = new JTextField(10);
    private JTextField txt_dead_balance_lira = new JTextField(10);
    private JTextField txt_dead_balance_dollar = new JTextField(10);
    private JLabel lbl_tot_price = new JLabel("TOTAL");
    private JTextField txt_tot_price_lira = new JTextField(10);
    private JTextField txt_tot_price_dollar = new JTextField(10);
    private JButton btn_OK = new JButton("OK");
    private JButton btn_confirm = new JButton("Confirm");
    private JOptionPane jop;
    float tot_price_lira_fixed = 0;
    float tot_price_dollar_fixed = 0;
    float change_lira = 0;
    float change_dollar = 0;
    float payed_lira = 0;
    float payed_dollar = 0;
    float dead_balance_lira = 0;
    float dead_balance_dollar = 0;
    float dollar_rate = 1500;
    JTextField[] array_txt_lira = { txt_cash_lira, txt_credit_lira, txt_check_lira };
    JTextField[] array_txt_dollar = { txt_cash_dollar, txt_credit_dollar, txt_check_dollar };
    JTextField[] array_change = { txt_change_lira, txt_change_dollar };
    String currency;
    // double minus_price;

    String action;

    zdialog(JFrame parent, String titre, boolean module, float price) {
        super(parent, titre, module);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        tot_price_lira_fixed = price;
        tot_price_dollar_fixed = price / dollar_rate;
        change_lira = price;
        change_dollar = price / dollar_rate;
        dead_balance_lira = -change_lira;
        dead_balance_dollar = -change_dollar;

        lbl_lira.setBounds(150, 40, 100, 20);
        lbl_dollar.setBounds(400, 40, 100, 20);

        lbl_cash.setBounds(50, 80, 100, 20);
        txt_cash_lira.setBounds(150, 80, 100, 20);
        txt_cash_dollar.setBounds(400, 80, 100, 20);

        lbl_credit.setBounds(50, 120, 100, 20);
        txt_credit_lira.setBounds(150, 120, 100, 20);
        txt_credit_dollar.setBounds(400, 120, 100, 20);

        lbl_check.setBounds(50, 160, 100, 20);
        txt_check_lira.setBounds(150, 160, 100, 20);
        txt_check_dollar.setBounds(400, 160, 100, 20);

        lbl_tot_price.setBounds(50, 300, 100, 20);
        txt_tot_price_lira.setBounds(150, 300, 100, 20);
        txt_tot_price_dollar.setBounds(400, 300, 100, 20);
        txt_tot_price_lira.setEditable(false);
        txt_tot_price_dollar.setEditable(false);
        txt_tot_price_lira.setText(String.valueOf(tot_price_lira_fixed));
        txt_tot_price_dollar.setText(String.valueOf(tot_price_dollar_fixed));

        lbl_still.setBounds(50, 340, 100, 20);
        txt_still_lira.setBounds(150, 340, 100, 20);
        txt_still_dollar.setBounds(400, 340, 100, 20);
        txt_still_lira.setEditable(false);
        txt_still_dollar.setEditable(false);
        txt_still_lira.setText(String.valueOf(tot_price_lira_fixed));
        txt_still_dollar.setText(String.valueOf(tot_price_dollar_fixed));

        lbl_change.setBounds(50, 380, 100, 20);
        txt_change_lira.setBounds(150, 380, 100, 20);
        txt_change_dollar.setBounds(400, 380, 100, 20);

        lbl_dead_balance.setBounds(50, 420, 100, 20);
        txt_dead_balance_lira.setBounds(150, 420, 100, 20);
        txt_dead_balance_dollar.setBounds(400, 420, 100, 20);
        txt_dead_balance_lira.setEditable(false);
        txt_dead_balance_dollar.setEditable(false);

        btn_OK.setBounds(400, 480, 100, 20);

        pan.setLayout(null);
        pan.add(lbl_lira);
        pan.add(lbl_dollar);

        pan.add(lbl_cash);
        pan.add(txt_cash_lira);
        pan.add(txt_cash_dollar);

        pan.add(lbl_credit);
        pan.add(txt_credit_lira);
        pan.add(txt_credit_dollar);

        pan.add(lbl_check);
        pan.add(txt_check_lira);
        pan.add(txt_check_dollar);

        pan.add(lbl_tot_price);
        pan.add(txt_tot_price_lira);
        pan.add(txt_tot_price_dollar);

        pan.add(lbl_still);
        pan.add(txt_still_lira);
        pan.add(txt_still_dollar);

        pan.add(lbl_change);
        pan.add(txt_change_lira);
        pan.add(txt_change_dollar);

        pan.add(lbl_dead_balance);
        pan.add(txt_dead_balance_lira);
        pan.add(txt_dead_balance_dollar);

        pan.add(btn_OK);
        frame.getRootPane().setDefaultButton(btn_OK);

        for (int i = 0; i <= array_txt_lira.length - 1; i++) {
            array_txt_lira[i].addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent event) {
                    currency = "lira";
                    action = "gain";
                    priceOfChange(event);
                }

                public void focusLost(FocusEvent event) {
                    currency = "lira";
                    action = "lost";
                    priceOfChange(event);
                }
            });
        }

        txt_change_lira.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent event) {
            }

            public void focusLost(FocusEvent event) {
                currency = "lira";
                priceOfDeadBalance(event);
            }
        });

        txt_change_dollar.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent event) {
            }

            public void focusLost(FocusEvent event) {
                currency = "dollar";
                priceOfDeadBalance(event);
            }
        });

        /*
         * for(int i=0;i<=array_txt_lira.length-1;i++){
         * array_txt_lira[i].getDocument().addDocumentListener(new DocumentListener() {
         * public void insertUpdate(DocumentEvent e){s="lira";priceOfChange(e);}
         * public void removeUpdate(DocumentEvent e){s="lira";priceOfChange(e);}
         * public void changedUpdate(DocumentEvent e) {s="lira";priceOfChange(e);}
         * });
         * }
         * 
         * for(int i=0;i<=array_txt_dollar.length-1;i++){
         * array_txt_dollar[i].getDocument().addDocumentListener(new DocumentListener()
         * {
         * public void insertUpdate(DocumentEvent e){s="dollar";priceOfChange(e);}
         * public void removeUpdate(DocumentEvent e){s="dollar";priceOfChange(e);}
         * public void changedUpdate(DocumentEvent e) {s="dollar";priceOfChange(e);}
         * });
         * }
         */

        btn_OK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new zdialog(null, "confirm", true, "confirm");
            }
        });

        /*
         * btn_confirm.addActionListener(new ActionListener(){
         * public void actionPerformed(ActionEvent event){
         * frame.setVisible(false);
         * }
         * });
         */

        frame.add(pan);
        frame.setVisible(true);

    }

    public void priceOfChange(FocusEvent e) {
        JTextField txt = (JTextField) e.getSource();
        if (action == "lost") {
            if (txt.getDocument().getLength() == 0) {
                payed_lira += 0;
                payed_dollar += 0;
            } else {
                if (currency == "lira") {
                    payed_lira += Float.parseFloat(txt.getText());
                    payed_dollar += Float.parseFloat(txt.getText()) / dollar_rate;
                } else {
                    payed_lira += Float.parseFloat(txt.getText()) * dollar_rate;
                    payed_dollar += Float.parseFloat(txt.getText());
                }
            }
            change_lira = tot_price_lira_fixed - payed_lira;
            change_dollar = tot_price_dollar_fixed - payed_dollar;
            txt_still_lira.setText(String.valueOf(change_lira));
            txt_still_dollar.setText(String.valueOf(change_dollar));
            dead_balance_lira = change_lira;
            dead_balance_dollar = change_dollar;
            txt_dead_balance_lira.setText(String.valueOf(-dead_balance_lira));
            txt_dead_balance_dollar.setText(String.valueOf(-dead_balance_dollar));
        } else {
            if (txt.getDocument().getLength() == 0) {
                payed_lira += 0;
                payed_dollar += 0;
            } else {
                if (currency == "lira") {
                    payed_lira -= Float.parseFloat(txt.getText());
                    payed_dollar -= Float.parseFloat(txt.getText()) / dollar_rate;
                } else {
                    payed_lira -= Float.parseFloat(txt.getText()) * dollar_rate;
                    payed_dollar -= Float.parseFloat(txt.getText());
                }
            }
            change_lira = tot_price_lira_fixed - payed_lira;
            change_dollar = tot_price_dollar_fixed - payed_dollar;
        }
    }

    public void priceOfDeadBalance(FocusEvent e) {
        JTextField txt = (JTextField) e.getSource();
        System.out.println(change_lira - Float.parseFloat(txt.getText()));
        if (currency == "lira") {
            dead_balance_lira = change_lira + Float.parseFloat(txt.getText());
            dead_balance_dollar = change_dollar + Float.parseFloat(txt.getText()) / dollar_rate;
        } else {
            dead_balance_lira = change_lira + Float.parseFloat(txt.getText()) * dollar_rate;
            dead_balance_dollar = change_dollar + Float.parseFloat(txt.getText());
        }
        txt_dead_balance_lira.setText(String.valueOf(dead_balance_lira));
        txt_dead_balance_dollar.setText(String.valueOf(dead_balance_dollar));
    }

    /*
     * public void priceOfChange(DocumentEvent e){
     * System.out.println("3atas");
     * Document doc = (Document)e.getDocument();
     * try{
     * minus_price=Double.parseDouble(doc.getText(0,doc.getLength()));
     * }
     * catch(Exception bad){}
     * try{
     * if(s=="lira"){
     * tot_price_lira = tot_price_lira_fixed-minus_price;
     * tot_price_dollar=tot_price_dollar_fixed-(minus_price/dollar_rate);
     * }
     * else{
     * tot_price_lira = tot_price_lira_fixed-(minus_price*dollar_rate);
     * tot_price_dollar=tot_price_dollar_fixed-minus_price;
     * }
     * txt_tot_price_lira.setText(String.valueOf(tot_price_lira));
     * txt_tot_price_dollar.setText(String.valueOf(tot_price_dollar));
     * 
     * 
     * }
     * catch(Exception t){jop.showMessageDialog(null,"the payment must be a number",
     * "error", JOptionPane.INFORMATION_MESSAGE);
     * }
     * }
     */

    zdialog(JFrame parent, String titre, boolean module) {
        super(parent, titre, module);
        frame3.setSize(600, 600);
        frame3.setLocationRelativeTo(null);
        frame3.setResizable(false);
        frame3.setVisible(true);
    }

    zdialog(JFrame parent, String titre, boolean module, String x) {
        super(parent, titre, module);
        frame2.setSize(300, 200);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);

        btn_confirm.setBounds(150, 100, 100, 20);

        btn_confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frame.setVisible(false);
                frame2.setVisible(false);
            }
        });

        frame2.getContentPane().setLayout(null);
        frame2.getContentPane().add(btn_confirm);
        frame2.setVisible(true);

    }
}
