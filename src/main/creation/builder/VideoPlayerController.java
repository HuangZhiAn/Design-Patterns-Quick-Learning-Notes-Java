package creation.builder;

public class VideoPlayerController {

    public VideoPlayer construct(AbstractVideoPlayerBuilder videoPlayerBuilder){
        if (videoPlayerBuilder.displayMainWindows())
            videoPlayerBuilder.buildMainWindows();
        if(videoPlayerBuilder.displayMenu())
            videoPlayerBuilder.buildMenu();
        if(videoPlayerBuilder.displayControlBar())
            videoPlayerBuilder.buildControlBar();
        if(videoPlayerBuilder.displayVideoList())
            videoPlayerBuilder.buildVideoList();
        if(videoPlayerBuilder.displayCollectionList())
            videoPlayerBuilder.buildCollectionList();
        videoPlayerBuilder.buildMode();
        return videoPlayerBuilder.createVideoPlayer();
    }
}
