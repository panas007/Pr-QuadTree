public class Qnode {


	private Qnode internal;
	
	int x;
	int y;
	int Xmin;
	int Xmax;
	int Ymin;
	int Ymax;
	Qnode NW;
	Qnode NE;
	Qnode SW;
	Qnode SE;
	boolean leaf;
	boolean divided;
	
	Qnode(int xmin,int ymin,int xmax,int ymax) //interanl node
    { 
		this.Xmin = xmin;
		this.Xmax = xmax;
		this.Ymin = ymin;
		this.Ymax = ymax;
        this.NW=null;
        this.NE=null;
        this.SW=null;
        this.SE=null;
        leaf=true;
        this.divided=false;

    }
	/**
	 *  
	 * @param x 
	 * @param y 
	 * @param xmin minimum x axis values 
	 * @param ymin minimum y axis values 
	 * @param xmax maximum x axis values 
	 * @param ymax maximum y axis values 
	 */
	Qnode(int x,int y,int xmin,int ymin,int xmax,int ymax) //leaf nodes
    { 
		this.Xmin = xmin;
		this.Xmax = xmax;
		this.Ymin = ymin;
		this.Ymax = ymax;
		this.x = x;
		this.y =y;
		leaf=true;

    }
	

	Qnode() //default nodes
    { 
		
    }
	
	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}



	public Qnode getInternal() {
		return internal;
	}

	public void setInternal(Qnode internal) {
		this.internal = internal;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getXmin() {
		return Xmin;
	}

	public void setXmin(int xmin) {
		Xmin = xmin;
	}

	public int getXmax() {
		return Xmax;
	}

	public void setXmax(int xmax) {
		Xmax = xmax;
	}

	public int getYmin() {
		return Ymin;
	}

	public void setYmin(int ymin) {
		Ymin = ymin;
	}

	public int getYmax() {
		return Ymax;
	}

	public void setYmax(int ymax) {
		Ymax = ymax;
	}

	public Qnode getNW() {
		return NW;
	}

	public void setNW(Qnode nW) {
		NW = nW;
	}

	public Qnode getNE() {
		return NE;
	}

	public void setNE(Qnode nE) {
		NE = nE;
	}

	public Qnode getSW() {
		return SW;
	}

	public void setSW(Qnode sW) {
		SW = sW;
	}

	public Qnode getSE() {
		return SE;
	}

	public void setSE(Qnode sE) {
		SE = sE;
	} 
	
	

}
