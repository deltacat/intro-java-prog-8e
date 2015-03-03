package resources;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyResources {
	
	private File currentPath = null; 
	private File rootPath = null;
	
	public MyResources(){
		currentPath = new File(getClass().getResource("").getPath());
		rootPath = currentPath.getParentFile().getParentFile();
	}

	public AudioClip getAudioClip(String audioName) {
		URL audioFilePathUrl = uri2Url(getAudioPath().resolve(audioName));
		return (null == audioFilePathUrl) ? null : Applet.newAudioClip(audioFilePathUrl);
	}
	
	public ImageIcon getImageIcon(String imageName) {
		URL imageFilePathUrl = uri2Url(getImagePath().resolve(imageName));
		return (null == imageFilePathUrl) ? null : (new ImageIcon(imageFilePathUrl));
	}

	private URI getAudioPath() {
		return rootPath.toURI().resolve("audio/");
	}
	
	private URI getImagePath() {
		return rootPath.toURI().resolve("image/");
	}
	
	private URL uri2Url(URI uri){
		URL url = null;
		try {
			url = uri.toURL();
		} catch (MalformedURLException e) {
			// TODO How to handle URL exception better here? And always return valid audio/image clip?
			e.printStackTrace();
		}
		return url;
	}
}
