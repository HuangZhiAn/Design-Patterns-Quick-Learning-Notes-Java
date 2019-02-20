package builder;

public class VideoPlayer {
    private String mode;
    private String menu;
    private String videoList;
    private String mainWindows;
    private String controlBar;
    private String collectionList;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getVideoList() {
        return videoList;
    }

    public void setVideoList(String videoList) {
        this.videoList = videoList;
    }

    public String getMainWindows() {
        return mainWindows;
    }

    public void setMainWindows(String mainWindows) {
        this.mainWindows = mainWindows;
    }

    public String getControlBar() {
        return controlBar;
    }

    public void setControlBar(String controlBar) {
        this.controlBar = controlBar;
    }

    public String getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(String collectionList) {
        this.collectionList = collectionList;
    }

    @Override
    public String toString() {
        return "VideoPlayer{" +
                "mode='" + mode + '\'' +
                ", menu='" + menu + '\'' +
                ", videoList='" + videoList + '\'' +
                ", mainWindows='" + mainWindows + '\'' +
                ", controlBar='" + controlBar + '\'' +
                ", collectionList='" + collectionList + '\'' +
                '}';
    }
}
