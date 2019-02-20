package structure.composite;

public class CompositeMain {
    public static void main(String[] args){
        Control button1,button2,panel1,textbox,window;
        button1 = new ButtonControl("按钮1");
        button2 = new ButtonControl("按钮2");
        panel1 = new PanelControl("文本框1");
        textbox = new TextboxControl("面板");
        window = new WindowControl("窗体");

        textbox.add(button1);
        textbox.add(panel1);
        window.add(button2);
        window.add(button1);
        window.add(textbox);

        window.display();
    }
}
