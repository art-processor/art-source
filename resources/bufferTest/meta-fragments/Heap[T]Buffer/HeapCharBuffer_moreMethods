
    String toString(int start, int end) {		// package-private
	try {
	    return new String(hb, start + offset, end - start);
	} catch (StringIndexOutOfBoundsException x) {
	    throw new IndexOutOfBoundsException();
	}
    }

    // --- Methods to support CharSequence ---

    public CharSequence subSequence(int start, int end) {
        if ((start < 0)
	    || (end > length())
	    || (start > end))
	    throw new IndexOutOfBoundsException();
        int len = end - start;
        return new HeapCharBuffer(hb,
				      -1, 0, len, len,
				      offset + position() + start);
    }
