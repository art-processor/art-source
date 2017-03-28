
    public ?@elmtType?Buffer slice() {
	return new Heap?@elmtType?BufferR(hb,
					-1,
					0,
					this.remaining(),
					this.remaining(),
					this.position());
    }

    public ?@elmtType?Buffer duplicate() {
	return new Heap?@elmtType?BufferR(hb,
					this.markValue(),
					this.position(),
					this.limit(),
					this.capacity(),
					offset);
    }

    public ?@elmtType?Buffer asReadOnlyBuffer() {

	return duplicate();

    }

    public boolean isReadOnly() {
	return true;
    }

    public ?@elmtType?Buffer put(?@elmttype? x) {

	throw new ReadOnlyBufferException();

    }

    public ?@elmtType?Buffer put(int i, ?@elmttype? x) {

	throw new ReadOnlyBufferException();

    }

    public ?@elmtType?Buffer put(?@elmttype?[] src, int offset, int length) {

	throw new ReadOnlyBufferException();

    }

    public ?@elmtType?Buffer put(?@elmtType?Buffer src) {

	throw new ReadOnlyBufferException();

    }

    public ?@elmtType?Buffer compact() {

	throw new ReadOnlyBufferException();

    }
