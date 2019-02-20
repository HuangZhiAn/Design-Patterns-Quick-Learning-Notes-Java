package factory.abstractt.game;

public interface ControllerFactory {
    InterfaceController createInterfaceController();
    OperationController createOperationController();
}
