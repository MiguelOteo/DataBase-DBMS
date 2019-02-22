package UImenu;

import java.io.*;
import db.jdbc.SQLManager;
import pojos.Client;

public class UserInterface {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SQLManager manager = new SQLManager();
		boolean everything_ok = manager.Create_tables();
		
		if(everything_ok == true) {
			System.out.println("Connection and tables charged");
			
			System.out.println("id of client: ");
			Integer id = br.read();
			System.out.println("Name of client: ");
			String name = br.readLine();
			System.out.println("name of responsible: ");
			String responsible = br.readLine();
			System.out.println("Telephone: ");
			Integer telef = br.read();
			System.out.println("Bank account: ");
			String bank_account = br.readLine();

			Client client = new Client(id, name, telef, bank_account, responsible);
			boolean insert_ok = manager.Inset_new_client(client);
			
			if(insert_ok == true) {
				System.out.println("Insertion done");
			} else {
				System.out.println("Insertion error accured");
			}
			manager.Close_connection();
		} else {
			System.out.println("Connection and tables charge failed");
		}
	}
}