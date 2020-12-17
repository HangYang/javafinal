package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MediaDemo {
	public MediaDemo() {
		try{
			String m1 = getClass().getResource("/Media/Micheal.mp4").toString();
			
			Media media = new Media( m1);
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			MediaView mediaView = new MediaView(mediaPlayer);
			
			Label lTime = new Label();
			Label time = new Label("time");
			Slider Stime = new Slider();
			Stime.setPrefWidth(150);
			Stime.setMaxWidth(Region.USE_PREF_SIZE);
			Stime.setMinWidth(30);
			Stime.setValue(50);
			Stime.valueProperty().addListener(e -> {
			      if (Stime.isValueChanging())
			      {
			        mediaPlayer.seek(mediaPlayer.getTotalDuration().multiply(Stime.getValue() / 100.0));
			      }
			});
			mediaPlayer.currentTimeProperty().addListener(e -> 
			{
			    Stime.setValue(mediaPlayer.getCurrentTime().divide(mediaPlayer.getMedia().getDuration()).toMillis() * 100.0);
			    lTime.setText(format((int)mediaPlayer.getCurrentTime().toSeconds() )+ "/" + format((int)mediaPlayer.getTotalDuration().toSeconds()));
			});
				
			Button play =new Button(">");
			play.setOnAction(e->{
				if(play.getText().equals(">")) {
					mediaPlayer.play();
					play.setText("||");
				}else {
					mediaPlayer.stop();
					play.setText(">");
					
				}
				
			});
			
			
			Button replay = new Button("<<");
			replay.setOnAction(e-> mediaPlayer.seek(Duration.ZERO));
			
			Label volume = new Label("Volume");
			Slider Svolume = new Slider();
			Svolume.setPrefWidth(150);
			Svolume.setMaxWidth(Region.USE_PREF_SIZE);
			Svolume.setMinWidth(30);
			Svolume.setValue(50);
			mediaPlayer.volumeProperty().bind(Svolume.valueProperty().divide(100));
			
			HBox hbox = new HBox(10);
			hbox.setAlignment(Pos.CENTER);
			hbox.getChildren().addAll(play,replay,time,Stime,lTime,volume,Svolume);
			
			BorderPane pane = new BorderPane();
			pane.setCenter(mediaView);
			pane.setBottom(hbox);
			mediaView.fitHeightProperty().bind(pane.heightProperty());
			mediaView.fitWidthProperty().bind(pane.widthProperty());
			
			
			Scene scene = new Scene(pane,1280,800);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
	public static String format(long seconds){
		int hour = (int)(seconds / 3600 % 24);
	    int minute = (int)(seconds / 60 % 60);
		int second = (int)(seconds % 60);
		return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + ":" + (second < 10 ? "0" + second : second);
	}
	
}