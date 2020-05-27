package me.varunon9.remotecontrolpc.mediaplayer;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import me.varunon9.remotecontrolpc.CallbackReceiver;
import me.varunon9.remotecontrolpc.MusicImageAvatar;
import me.varunon9.remotecontrolpc.Utility;

public abstract class SongsList extends AsyncTask<Void, Void, ArrayList<MusicImageAvatar>> implements CallbackReceiver {
	Context context;
	public SongsList(Context context) {
		this.context = context;
	}
	protected ArrayList<MusicImageAvatar> doInBackground(Void... params) {
		ArrayList<MusicImageAvatar> songsList = new ArrayList<MusicImageAvatar>();
		ContentResolver musicResolver = context.getContentResolver();
    	Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);
        Utility utility = new Utility();
    	if (musicCursor!=null && musicCursor.moveToFirst()) {
    		int titleColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.TITLE);
    		int artistColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.ARTIST);
    		int dataColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.DATA);
    		int durationColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.DURATION);
    		int albumIdColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.ALBUM_ID);
    		do {
    			String thisTitle = musicCursor.getString(titleColumn);
    			String thisArtist = musicCursor.getString(artistColumn);
    			String thisData = musicCursor.getString(dataColumn);
    			int thisDuration = musicCursor.getInt(durationColumn);
    			int thisAlbumId = musicCursor.getInt(albumIdColumn);
    			String subHeading = thisArtist + ", " + utility.getDuration(thisDuration);
    			songsList.add(new MusicImageAvatar(thisAlbumId, thisDuration, thisTitle, subHeading, thisData, "music"));
    		} while (musicCursor.moveToNext());
    	}
    	Collections.sort(songsList,new Comparator<MusicImageAvatar>() {
			public int compare(MusicImageAvatar a, MusicImageAvatar b) {
				return a.getHeading().compareTo(b.getHeading());
			}
		});
		return songsList;
	}
	@Override
	protected void onPostExecute(ArrayList<MusicImageAvatar> songsList) {
		receiveData(songsList);
	}
	@Override
	public abstract void receiveData(Object result);
}
