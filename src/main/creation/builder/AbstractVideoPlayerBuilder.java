package creation.builder;

/**
 * 建造者抽象类
 */
public abstract class AbstractVideoPlayerBuilder {
    protected VideoPlayer v = new VideoPlayer();

    public abstract void buildMenu();
    public abstract void buildVideoList();
    public abstract void buildMainWindows();
    public abstract void buildControlBar();
    public abstract void buildCollectionList();
    public abstract void buildMode();

    public VideoPlayer createVideoPlayer(){
        return v;
    }

    public boolean displayMenu(){
        return false;
    }

    public boolean displayVideoList(){
        return false;
    }

    public boolean displayMainWindows(){
        return false;
    }

    public boolean displayControlBar(){
        return false;
    }
    public boolean displayCollectionList(){
        return false;
    }

    public VideoPlayer construct(){
        if (displayMainWindows())
            this.buildMainWindows();
        if(displayMenu())
            this.buildMenu();
        if(displayControlBar())
            this.buildControlBar();
        if(displayVideoList())
            this.buildVideoList();
        if(displayCollectionList())
            this.buildCollectionList();
        this.buildMode();
        return v;
    }
}
