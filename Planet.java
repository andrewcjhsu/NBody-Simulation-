public class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}
	public Planet(Planet p){
		this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
	}

	public double calcForceExertedBy(Planet z){
		double G=6.67*Math.pow(10,-11);
		double dx=z.xxPos-this.xxPos;
		double dy=z.yyPos-this.yyPos;
		double r=calcDistance(this);
		double f=G*this.mass*z.mass/Math.pow(r,2);
		return f;
	}
	public double calcForceExertedByX(Planet z){
		double G=6.67*Math.pow(10,-11);
		double dx=z.xxPos-this.xxPos;
		double dy=z.yyPos-this.yyPos;
		double r=Math.sqrt(dx*dx+dy*dy);
		double f=G*this.mass*z.mass/Math.pow(r,2);
		double fx=f*dx/r;
		return fx;

	}
	public double calcForceExertedByY(Planet z){
		double G=6.67*Math.pow(10,-11);
		double dx=z.xxPos-this.xxPos;
		double dy=z.yyPos-this.yyPos;
		double r=Math.sqrt(dx*dx+dy*dy);
		double f=G*this.mass*z.mass/Math.pow(r,2);
		double fy=f*dy/r;
		return fy;
	}
	public double calcDistance (Planet z){
		double dx=z.xxPos-this.xxPos;
		double dy=z.yyPos-this.yyPos;
		double r=Math.abs(dx*dx+dy*dy);
		return r;
	}

	public double calcNetForceExertedByX (Planet [] all){
		double netfx=0;
		for (int i=0;i<all.length;i++){
		if(this.equals(all[i])){
				netfx=netfx;
			}
			else{
			netfx=netfx+this.calcForceExertedByX(all[i]);
			}
		}
		return netfx;
	}

	public double calcNetForceExertedByY (Planet [] all){
		double netfy=0;
		for (int i=0;i<all.length;i++){
			if(this.equals(all[i])){
				netfy=netfy;
			}
			else{
			netfy=netfy+this.calcForceExertedByY(all[i]);
			}
		}
		return netfy;
	}

	public void update(double dt, double fx, double fy){
		double ax=fx/mass;
		double ay=fy/mass;
		double vx=this.xxVel+dt*ax;
		double vy=this.yyVel+dt*ay;
		double px=this.xxPos+dt*vx;
		double py=this.yyPos+dt*vy;
		this.xxVel=vx;
		this.yyVel=vy;
		this.xxPos=px;
		this.yyPos=py;
	}

	public void draw(){
		String planet="./images/"+this.imgFileName;
		StdDraw.picture(this.xxPos,this.yyPos,planet);
	}





}