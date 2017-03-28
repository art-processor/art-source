
    Direct?@elmtType?Buffer?@ByteOrder?(DirectByteBuffer bb) { 	// package-private
	super(-1, 0,
	      bb.remaining() >> ?@elmtSize?,
	      bb.remaining() >> ?@elmtSize?);
	// enforce limit == capacity
	int cap = this.capacity();
	this.limit(cap);
	int pos = this.position();
	assert (pos <= cap);
 	address = bb.address() + pos;
	allocated = false;
	viewedBuffer = bb;

    }
