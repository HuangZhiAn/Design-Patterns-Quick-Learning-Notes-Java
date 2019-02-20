package creation.factory.abstractt.game;

public class SymbianControllerFactory implements ControllerFactory {
    @Override
    public InterfaceController createInterfaceController() {
        return new SymbianInterfaceController();
    }

    @Override
    public OperationController createOperationController() {
        return new SymbianOperationController();
    }
}
