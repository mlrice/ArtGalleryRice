package view;

import java.util.List;
import java.util.Scanner;

import controller.GalleryItemHelper;
import model.GalleryItem;


public class StartGalleryProgram {

	static Scanner in = new Scanner(System.in);
	static GalleryItemHelper gih = new GalleryItemHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title: ");
		String title = in.nextLine();
		System.out.print("Enter the artist name: ");
		String artistName = in.nextLine();
		System.out.print("Enter the media: ");
		String media = in.nextLine();
		System.out.print("Enter the year: ");
		String year = in.nextLine();
		System.out.print("Enter the value: ");
		Double value = in.nextDouble();
		
		GalleryItem toAdd = new GalleryItem(title, artistName, media, year, value);
		gih.insertItem(toAdd);


	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title to delete: ");
		String title = in.nextLine();
		//System.out.print("Enter the item to delete: ");
		//String item = in.nextLine();
		
		GalleryItem toDelete = new GalleryItem(title);
		gih.deleteItem(toDelete);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the gallery list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Delete an item");
			System.out.println("*  3 -- View the gallery inventory");
			System.out.println("*  4 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				deleteAnItem();
			} else if (selection == 3) {
				viewTheList();
			} else {
				//lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
			}
	}
			private static void viewTheList() {
				// TODO Auto-generated method stub
				List<GalleryItem> allItems = gih.showAllItems();
				for (GalleryItem gih : allItems) {
					System.out.println(gih.returnItemDetials());
				}

			}
	
}
