public class GreetingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Objetivo do teste: verificar se, ao acessar o endpoint "/greeting" 
     * sem fornecer nenhum parâmetro, o sistema retorna a mensagem padrão 
     * "Hello, World!" com status HTTP 200 (OK).
     */
    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    /**
     * Objetivo do teste: verificar se, ao acessar o endpoint "/greeting" 
     * fornecendo o parâmetro "name", o sistema retorna uma mensagem personalizada 
     * incluindo o nome fornecido, com status HTTP 200 (OK).
     */
    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {
        this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
    }
}
