/**
 * 
 */
package at.application.view;

import java.io.OutputStream;
import java.io.PrintStream;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

/**
 * @author Fabian Maurutschek
 * @version 1.0 lab23
 *
 */
public class DebugPane extends BorderPane{
	TextArea ta = new TextArea();

	public DebugPane(){
		init();
		PrintStream ps = System.out;
		System.setOut(new PrintStream(new StreamCapturer("Game", ta, ps)));
	}

	private void init(){
		ta.setEditable(false);
		setCenter(ta);
	}

	public class StreamCapturer extends OutputStream{

		private StringBuilder buffer;
		private String prefix;
		private TextArea consumer;
		private PrintStream old;

		public StreamCapturer(String prefix, TextArea consumer, PrintStream old){
			this.prefix = prefix;
			buffer = new StringBuilder(128);
			buffer.append("[").append(prefix).append("] ");
			this.old = old;
			this.consumer = consumer;
		}

		@Override
		public void write(int b){
			char c = (char) b;
			String value = Character.toString(c);
			buffer.append(value);
			if(value.equals("\n")){
				consumer.appendText(buffer.toString());
				buffer.delete(0, buffer.length());
				buffer.append("[").append(prefix).append("] ");
			}
			old.print(c);
		}
	}
}
