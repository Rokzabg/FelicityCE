package Build0_4__3_3_20;

class Coords {
	
	int x;
	int y;
	
	Coords(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public Coords sum(Coords adding) {
		
		return new Coords(this.x+adding.x,this.y+adding.y);
		
	}
	
	public Coords sub(Coords adding) {
		
		return new Coords(this.x-adding.x,this.y-adding.y);
		
	}
	
	public String toString() {
		
		return ("[" + x + "][" + y + "]");
		
	}

}
