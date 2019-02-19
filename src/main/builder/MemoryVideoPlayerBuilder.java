package builder;

public class MemoryVideoPlayerBuilder extends AbstractVideoPlayerBuilder {

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
    public void buildCollectionList() {
        v.setCollectionList("显示收藏列表");
    }

    @Override
    public void buildMode() {
        v.setMode("记忆模式");
    }

    public boolean displayMainWindows(){
        return true;
    }

    public boolean displayControlBar(){
        return true;
    }
    public boolean displayCollectionList(){
        return true;
    }
}
