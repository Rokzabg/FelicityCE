package _Main;

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
	
	public boolean equals(Coords other) {
		
		if (this.x==other.x && this.y==other.y) return true;
		
		else return false;
		
	}

}
