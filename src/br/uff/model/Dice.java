package br.uff.model;

public class Dice {
	
    private String img;
    private Integer x, y;
    private Integer value;
    
	public Dice(String img, Integer x, Integer y, Integer value) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
    
}
