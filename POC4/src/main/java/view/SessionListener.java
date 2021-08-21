package view;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session destroyed");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Attribute is Removed!!");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Attribute is Replaced!!");
	}
}
