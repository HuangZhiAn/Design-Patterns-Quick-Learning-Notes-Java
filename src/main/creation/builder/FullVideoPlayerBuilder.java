package creation.builder;

public class FullVideoPlayerBuilder extends AbstractVideoPlayerBuilder {
    @Override
    public void buildMenu() {
        v.setMenu("显示菜单");
    }

    @Override
    public void buildVideoList() {
        v.setVideoList("显示播放列表");
    }

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

    }

    @Override
    public void buildMode() {
        v.setMode("完整模式");
    }

    public boolean displayMenu(){
        return true;
    }

    public boolean displayVideoList(){
        return true;
    }

    public boolean displayMainWindows(){
        return true;
    }

    public boolean displayControlBar(){
        return true;
    }
}
