package unitTests;

import list.CustomList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Admin on 6.8.2016 г..
 */
public class TestCustomList {

    private CustomList<Integer> customList;

    @Before
    public void setUp(){
        this.customList = new CustomList<Integer>();
    }

    @Test
    public void testAddMethod_addOneElement_addedSuccessfully(){
        int element = 5;

        boolean result = this.customList.addElement(element);

        Assert.assertTrue(result);
    }

    @Test
    public void testRemoveMethod_removeOneElement_removedSuccessfully(){
        int element = 5;

        this.customList.addElement(element);
        int removedElement = this.customList.removeElement(0);

        Assert.assertEquals(element, removedElement);
    }

    //IndexOutOfBoundsException("Index not in range!"
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveMethod_removeElementAtWrongIndex_shouldThrow(){
        int element = 5;

        this.customList.addElement(element);
        this.customList.removeElement(1);
    }

    //IndexOutOfBoundsException("Index not in range!"
    @Test
    public void testRemoveMethod_removeElementAtWrongIndex_shouldThrowAndShowMessage(){
        int element = 5;
        this.customList.addElement(element);
        String expected = "Index not in range!";

        String actual = null;
        try {
            this.customList.removeElement(1);
        }catch (IndexOutOfBoundsException ex){
            actual = ex.getMessage();
        }

        Assert.assertEquals(expected, actual);
    }


}
