package JMS;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import JMS.config.AppConfig;
import JMS.receiver.MessageReceiver;



public class MessageConsumerApp
{

	public static void main(String[] args)
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReceiver");
		String response = messageReceiver.receiveMessage();
		System.out.println("Messgae Received = " + response);

		((AbstractApplicationContext) context).close();
	}

}
