package art.processor;

import java.io.IOException;

import art.utils.ProcessData;


/**
 * Abstract processor class. Can be used to make other processor types.
 */
public abstract class Processor {

	protected ProcessData processData;
	protected String inputFile;

	/**
	 * Initialization of processing data, and other actions before starting the process.
	 * 
	 * @param inputFile
	 *            - the SPC file's path
	 * @throws IOException
	 */
	public abstract void beforeProcess(String inputFile) throws IOException;

	/**
	 * Process of the input
	 */
	public abstract void process();

	/**
	 * Actions when the process is over. Closing output, freeing resources...
	 * 
	 * @throws IOException
	 */
	public abstract void afterProcess() throws IOException;

	public void run() throws IOException {
		beforeProcess(inputFile);
		process();
		afterProcess();
	}

	public abstract ProcessData getProcessData();

	public abstract void setProcessData(ProcessData processData);

}
