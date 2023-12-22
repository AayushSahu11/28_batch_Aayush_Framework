package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class handle_DropDown_List 
{
	// it is a most important Code real time use hota hai.
	public static void handleSelectClass(WebElement element, String value) // element means element jisme dropdown hoga
	// element means element jisme dropdown hoga means element k code I will write wo element me hoga
	// and string value me jo option likha tha "price (low to high)" yeh and baki option store honge
	{
		Select sc=new Select(element); // dropdown box ko select kia by creating object
		sc.selectByVisibleText(value); //now used filter of that dropdown with inspect in black text() wale options
	}
}
