package action.command;

public class OpenCommand implements Command{
    private BoardScreen boardScreen = new BoardScreen();

    @Override
    public void execute() {
        boardScreen.open();
    }
}
