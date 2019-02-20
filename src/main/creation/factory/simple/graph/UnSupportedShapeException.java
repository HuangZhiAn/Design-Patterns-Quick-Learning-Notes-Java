package factory.simple.graph;

class UnSupportedShapeException extends Exception{

    UnSupportedShapeException(String message) {
        super(message);// 把参数传递给Throwable的带String参数的构造方法
    }
}
