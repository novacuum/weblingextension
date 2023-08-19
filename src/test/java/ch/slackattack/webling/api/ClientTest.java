package ch.slackattack.webling.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {
	private String host = "sandbox";
	private String apiKey = "b1121cb7e5204f1dd0077591d7323afe";

	private Client client;

	@BeforeEach
	public void setup() {
		this.client = new Client(host, apiKey);
	}

	@Test
	public void shouldGetMembers() {
		Integer[] actualValue = client.getMembers();
		assertEquals(498, actualValue.length, "has x items");
	}

	@Test
	public void shouldGetMember() {
		// Integer[] members = client.getMembers();

		Member actualValue = client.getMember(1124);


		//test against not null
		

		assertEquals(actualValue.getProperties().getName(), "test", "is test user");
		

		// TODO: assert scenario
	}

	@Test
	public void shouldUpdateDebitor() {
		client.updateDebitor(4465, 954);
	}
}
