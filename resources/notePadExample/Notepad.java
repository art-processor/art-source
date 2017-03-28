	
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.*;


class Notepad extends JPanel {

	Notepad() {
		super();

		String lfClassName;
		
			lfClassName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			
		try {
		  UIManager.setLookAndFeel(lfClassName);
		} catch (Exception exc) {
		  System.err.println("Could not load LookAndFeel: " + lfClassName);
		}

		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BorderLayout());
	
		JScrollPane scroller = new JScrollPane();
		JViewport port = scroller.getViewport();
		port.add(editor);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());	
		panel.add("North", toolbar);
		panel.add("Center", scroller);

		add("Center", panel);
		add("North", menubar);
		add("South", statusbar);
		}

		public static void main(String[] args) {
			try {
				JFrame frame = new JFrame();
				frame.setTitle("A Notepad");
				frame.setBackground(Color.lightGray);

		
			frame.getContentPane().setLayout(new BorderLayout());
			frame.getContentPane().add("Center", new Notepad());
			frame.pack();
			frame.setSize(500, 600);
			frame.addWindowListener(new AppCloser());
			frame.show();
		} catch (Throwable t) {
			System.out.println("Exception: " + t);
			t.printStackTrace();
		}
	}        

	protected static final class AppCloser extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
	  
	
		System.exit(0);		}
	}

	
	private JTextComponent editor = createEditor();


	/**
	 * Create an editor to represent the given document.  
	 */
	protected JTextComponent createEditor() {

		JTextComponent editor = new JTextArea();
		editor.setFont(new Font("monospaced", Font.PLAIN, 12));
	return editor;
	}
	private JMenuBar menubar = createMenubar();

	/**
	 * Create a Java menubar
	 */
	protected JMenuBar createMenubar() {
		JMenuBar mb = new JMenuBar();
		JMenu m;
		JMenuItem mi;
	
		m = new JMenu("File");
		
			
			mi = new JMenuItem("New");
			mi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewFile();
			}
			});
			m.add(mi);
				
			
			mi = new JMenuItem("Open");
			mi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenFile();
			}
			});
			m.add(mi);
				
			
			mi = new JMenuItem("Save");
			mi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveFile();
			}
			});
			m.add(mi);
				
			
				m.addSeparator();
				
			
			mi = new JMenuItem("Exit");
			mi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
			});
			m.add(mi);
				mb.add(m);
		m = new JMenu("Edit");
		
			
			mi = new JMenuItem("Cut");
			mi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cut();
			}
			});
			m.add(mi);
				
			
			mi = new JMenuItem("Copy");
			mi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Copy();
			}
			});
			m.add(mi);
				
			
			mi = new JMenuItem("Paste");
			mi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paste();
			}
			});
			m.add(mi);
				mb.add(m);
		m = new JMenu("Help");
		
			
			mi = new JMenuItem("About");
			mi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About();
			}
			});
			m.add(mi);
				mb.add(m);	return mb;
	}



		
			
	private void NewFile() {
	
		Document oldDoc = editor.getDocument();
		editor.setDocument(new PlainDocument());
		revalidate();	}

			
		
			

	/**
	 * Thread to load a file into the text storage model
	 */
	class FileLoader extends Thread {

	FileLoader(File f, Document doc) {
		setPriority(4);
		this.f = f;
		this.doc = doc;
	}

	public void run() {

	try {
		// initialize the statusbar
		statusbar.removeAll();
		JProgressBar progress = new JProgressBar();
		progress.setMinimum(0);
		progress.setMaximum((int) f.length());
		statusbar.add(progress);
		statusbar.revalidate();

		// try to start reading
		Reader in = new FileReader(f);
		char[] buff = new char[4096];
		int nch;
		while ((nch = in.read(buff, 0, buff.length)) != -1) {
			doc.insertString(doc.getLength(), new String(buff, 0, nch), null);
			progress.setValue(progress.getValue() + nch);
		}

		// we are done... get rid of progressbar
		statusbar.removeAll();
		statusbar.revalidate();
	}
	catch (IOException e) {
		System.err.println(e.toString());
	}
	catch (BadLocationException e) {
		System.err.println(e.getMessage());
	}
	}

	Document doc;
	File f;
	}
	private FileDialog fileDialog;

	private void OpenFile() {


	    Frame frame = getFrame();
	    if (fileDialog == null) {
		fileDialog = new FileDialog(frame);
	    }
	    fileDialog.setMode(FileDialog.LOAD);
	    fileDialog.show();

	    String file = fileDialog.getFile();
	    if (file == null) {
		return;
	    }
	    String directory = fileDialog.getDirectory();
	    File f = new File(directory, file);
	    if (f.exists()) {
		Document oldDoc = editor.getDocument();
		editor.setDocument(new PlainDocument());
		frame.setTitle(file);
		Thread loader = new FileLoader(f, editor.getDocument());
		loader.start();
	    }
	}

    /**
     * Find the hosting frame, for the file-chooser dialog.
     */
    protected Frame getFrame() {
	for (Container p = getParent(); p != null; p = p.getParent()) {
	    if (p instanceof Frame) {
		return (Frame) p;
	    }
	}
	return null;
    }
			
		
			
	private void SaveFile() {
	
		JOptionPane.showMessageDialog(this, "This functionality is left for readers to implement", 
		"Save", JOptionPane.INFORMATION_MESSAGE);
          
		return;	}

			
		
			
		
			
	private void Exit() {
	
	System.exit(0);	}

			
		
			    private void Cut() {
	editor.cut();
    }

			
		
			     private void Copy() {
	    editor.copy();
      }

			
		
			        private void Paste() {
	   editor.paste();
	 }

			
		
			
	private void About() {


	JOptionPane.showMessageDialog(this, "About Message", 
	"About", JOptionPane.PLAIN_MESSAGE);

	return;
	}

			
	private JToolBar toolbar = (JToolBar)createToolbar();

	/**
	 * Create a Java toolbar. 
	 */
	private Component createToolbar() {
		JToolBar toolbar = new JToolBar();
		JButton  button; 
	
		
			button = new JButton(new ImageIcon("resources/new.gif"));    
			button.setToolTipText("Create a new file");
			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
				NewFile();
				}
				});
				toolbar.add(button);	
			
		
			button = new JButton(new ImageIcon("resources/open.gif"));    
			button.setToolTipText("Open a file");
			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
				OpenFile();
				}
				});
				toolbar.add(button);	
			
		
			button = new JButton(new ImageIcon("resources/save.gif"));    
			button.setToolTipText("Save to a file");
			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
				SaveFile();
				}
				});
				toolbar.add(button);	
			
		
			toolbar.add(Box.createHorizontalStrut(5));
			
		
			button = new JButton(new ImageIcon("resources/cut.gif"));    
			button.setToolTipText("Move selection to clipboard");
			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Cut();
				}
				});
				toolbar.add(button);	
			
		
			button = new JButton(new ImageIcon("resources/copy.gif"));    
			button.setToolTipText("Copy selection to clipboard");
			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Copy();
				}
				});
				toolbar.add(button);	
			
		
			button = new JButton(new ImageIcon("resources/paste.gif"));    
			button.setToolTipText("Paste clipboard to selection");
			button.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Paste();
				}
				});
				toolbar.add(button);	
					toolbar.add(Box.createHorizontalGlue());
		return toolbar;
	}


	private JComponent statusbar = (JComponent)createStatusbar();   

	/**
	* Create a status bar
	*/
	protected JComponent createStatusbar() {
		// need to do something reasonable here
	StatusBar status = new StatusBar();
	return status;
	}

	class StatusBar extends JComponent {

	public StatusBar() {
		super();
	
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));	}

	public void paint(Graphics g) {
	
		super.paint(g);	}
	}

}

