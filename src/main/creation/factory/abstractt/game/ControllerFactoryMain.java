package creation.factory.abstractt.game;

public class ControllerFactoryMain {

    public static void main(String[] args){
        ControllerFactory controllerBean = XmlUtil.getControllerBean();
        InterfaceController interfaceController = controllerBean.createInterfaceController();
        OperationController operationController = controllerBean.createOperationController();
        interfaceController.interfaceController();
        operationController.operaionController();
    }
}
