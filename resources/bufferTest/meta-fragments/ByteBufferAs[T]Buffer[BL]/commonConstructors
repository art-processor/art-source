
    ByteBufferAs?@elmtType?Buffer?@ByteOrder?(ByteBuffer bb) {	// package-private

	super(-1, 0,
	      bb.remaining() >> ?@elmtSize?,
	      bb.remaining() >> ?@elmtSize?);
	this.bb = bb;
	// enforce limit == capacity
	int cap = this.capacity();
	this.limit(cap);
	int pos = this.position();
	assert (pos <= cap);
	offset = pos;

    }

    ByteBufferAs?@elmtType?Buffer?@ByteOrder?(ByteBuffer bb,
				     int mark, int pos, int lim, int cap,
				     int off)
    {

	super(mark, pos, lim, cap);
	this.bb = bb;
	offset = off;

    }
