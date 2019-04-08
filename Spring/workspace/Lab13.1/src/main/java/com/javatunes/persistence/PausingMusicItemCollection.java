package com.javatunes.persistence;

import java.util.Collection;
import java.util.Iterator;

import com.javatunes.domain.MusicItem;

public class PausingMusicItemCollection implements Iterable<MusicItem> {
	
	private Collection<MusicItem> data;
	
	public PausingMusicItemCollection(Collection<MusicItem> dataIn) {
		data = dataIn;
	}
	
    public Iterator<MusicItem> iterator() {
        return new PausingIterator(data.iterator());
    }
    
    private class PausingIterator implements Iterator<MusicItem> {

      private Iterator<MusicItem> baseIterator;
    	  private int index = 0;

    	  public PausingIterator(Iterator<MusicItem> iteratorIn) {
    		baseIterator = iteratorIn;
    	  }

    	  public boolean hasNext() {
    		return baseIterator.hasNext();
    	  }

    	  public MusicItem next() {
    		index++;
    		MusicItem cur = baseIterator.next();
    		try {
    			if (index%3==0) { Thread.sleep(2000); }
    		} catch (Exception e ) { e.printStackTrace(); }
    		
    		return cur;
    	  }

      public void remove() {
         throw new UnsupportedOperationException();
      }
    
    }
}
	
