import io.javalin.Javalin;
import net.revature.martiantools.controllers.ProductController;

public class Driver {
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(7002);
		
//		CORS error-patch
		app.after(ctx-> {
			ctx.res.addHeader("Access-Control-Allow-Origin", "null");	
		})	;
		
		app.get("/test", ctx -> {
			ctx.result("hello from driver - port 7002) ");
			});
		
		ProductController productController = new ProductController(app);
	}
	


	
}
