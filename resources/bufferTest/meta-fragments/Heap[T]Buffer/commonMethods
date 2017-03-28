
    public ?@elmtType?Buffer slice() {
	return new Heap?@elmtType?Buffer(hb,
					-1,
					0,
					this.remaining(),
					this.remaining(),
					this.position());
    }

    public ?@elmtType?Buffer duplicate() {
	return new Heap?@elmtType?Buffer(hb,
					this.markValue(),
					this.position(),
					this.limit(),
					this.capacity(),
					offset);
    }

    public ?@elmtType?Buffer asReadOnlyBuffer() {

	return new Heap?@elmtType?BufferR(hb,
				     this.markValue(),
				     this.position(),
				     this.limit(),
				     this.capacity(),
				     offset);

    }

    protected int ix(int i) {
	return i + offset;
    }

    public ?@elmttype? get() {
	return hb[ix(nextGetIndex())];
    }

    public ?@elmttype? get(int i) {
	return hb[ix(checkIndex(i))];
    }

    public ?@elmtType?Buffer get(?@elmttype?[] dst, int offset, int length) {
	checkBounds(offset, length, dst.length);
	if (length > remaining())
	    throw new BufferUnderflowException();
	System.arraycopy(hb, ix(position()), dst, offset, length);
	position(position() + length);
	return this;
    }

    public boolean isDirect() {
	return false;
    }

    public boolean isReadOnly() {
	return false;
    }

    public ?@elmtType?Buffer put(?@elmttype? x) {

	hb[ix(nextPutIndex())] = x;
	return this;

    }

    public ?@elmtType?Buffer put(int i, ?@elmttype? x) {

	hb[ix(checkIndex(i))] = x;
	return this;

    }

    public ?@elmtType?Buffer put(?@elmttype?[] src, int offset, int length) {

	checkBounds(offset, length, src.length);
	if (length > remaining())
	    throw new BufferOverflowException();
	System.arraycopy(src, offset, hb, ix(position()), length);
	position(position() + length);
	return this;

    }

    public ?@elmtType?Buffer put(?@elmtType?Buffer src) {

	if (src instanceof Heap?@elmtType?Buffer) {
	    if (src == this)
		throw new IllegalArgumentException();
	    Heap?@elmtType?Buffer sb = (Heap?@elmtType?Buffer)src;
	    int n = sb.remaining();
	    if (n > remaining())
		throw new BufferOverflowException();
	    System.arraycopy(sb.hb, sb.ix(sb.position()),
			     hb, ix(position()), n);
	    sb.position(sb.position() + n);
	    position(position() + n);
	} else {
	    super.put(src);
	}
	return this;

    }

    public ?@elmtType?Buffer compact() {

	System.arraycopy(hb, ix(position()), hb, ix(0), remaining());
	position(remaining());
	limit(capacity());
	return this;

    }
