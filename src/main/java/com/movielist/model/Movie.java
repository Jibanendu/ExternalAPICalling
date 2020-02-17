package com.movielist.model;

import java.io.Serializable;
import java.util.List;

public class Movie  implements Serializable{
	private int page; 
	private int total_results; 
	private int total_pages; 
	private Result results;
	
	
	public Movie(int page, int total_results, int total_pages, Result results) {
		super();
		this.page = page;
		this.total_results = total_results;
		this.total_pages = total_pages;
		this.results = results;
	}
	
	
	public Movie() {

	}


	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal_results() {
		return total_results;
	}
	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public Result getResult() {
		return results;
	}
	public void setResult(Result results) {
		this.results = results;
	}


	@Override
	public String toString() {
		return "Movie [page=" + page + ", total_results=" + total_results
				+ ", total_pages=" + total_pages + ", result=" + results + "]";
	} 

}
