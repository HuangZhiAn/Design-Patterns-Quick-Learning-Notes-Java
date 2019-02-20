package creation.builder;

public class SimpleVideoPlayerBuilder extends AbstractVideoPlayerBuilder {
    @Override
    public void buildMenu() {}

    @Override
    public void buildVideoList() {}

    @Override
    public void buildMainWindows() {
        v.setMainWindows("显示主窗口");
    }

    @Override
    public void buildControlBar() {
        v.setControlBar("显示控制条");
    }

    @Override
    public void buildCollectionList() {}

    @Override
    public void buildMode() {
        v.setMode("精简模式");
    }

    public boolean displayMainWindows(){
        return true;
    }

    public boolean displayControlBar(){
        return true;
    }
}
