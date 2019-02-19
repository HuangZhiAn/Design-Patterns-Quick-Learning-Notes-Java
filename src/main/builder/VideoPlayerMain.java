package builder;

public class VideoPlayerMain {
    public static void main(String[] args){
        AbstractVideoPlayerBuilder playerBuilder = XmlUtil.getControllerBean();
        VideoPlayerController videoPlayerController = new VideoPlayerController();
        VideoPlayer videoPlayer = videoPlayerController.construct(playerBuilder);
        System.out.println(videoPlayer);
    }
}
