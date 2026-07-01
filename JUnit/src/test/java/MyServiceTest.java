import org.ashutosh.ExternalApi;
import org.ashutosh.MyService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MyServiceTest {
    @Test
    public void testExternalApi() {
        // Arrange
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        // Act
        String result = service.fetchData();

        // Assert
        assertEquals("Mock Data",result);
    }
}
