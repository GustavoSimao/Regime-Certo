Regime Certo — Simulador de Enquadramento Tributário

Sistema web para auxiliar empreendedores brasileiros a identificar o regime tributário adequado com base no faturamento anual da empresa.

MVP em desenvolvimento ativo. O sistema já permite análise rápida e cadastro de empresas. Funcionalidades adicionais estão previstas no roadmap.

📋 Sobre o Projeto

O Regime Certo resolve um problema comum: pequenos empreendedores frequentemente não sabem se estão no regime tributário correto, não acompanham o quanto já consumiram do limite e não possuem uma visão clara da evolução do faturamento.

A proposta inicial é simples: o usuário informa o faturamento anual e recebe o regime ideal, o status e uma mensagem orientativa.

A evolução do projeto inclui:

análise com uso de IA
histórico de faturamento
recomendação de contadores por localização

O código é público sob licença MIT. Os dados coletados, sempre com consentimento, serão utilizados de forma agregada e anonimizada para análises futuras.

💼 Regimes Tributários e Limites
Regime	Teto Anual
MEI — Microempreendedor Individual	R$ 81.000,00
ME — Microempresa	R$ 360.000,00
EPP — Empresa de Pequeno Porte	R$ 4.800.000,00
Empresa de Grande Porte	Acima do EPP


🚦 Status do Faturamento
Status	Condição	Significado
OK	< 70% do teto	Faturamento confortável
ALERTA	70% a 100% do teto	Atenção ao limite
EXCEDIDO	> 100% do teto	Teto ultrapassado. Procure um contador


🛠️ Tecnologias
Backend
Java 21
Spring Boot 3.4.5
Spring Web
Spring Data JPA
Bean Validation

Banco de dados
MySQL

Frontend
HTML5
CSS
JavaScript

🚀 Como Executar
Pré-requisitos
Java 21
Maven
MySQL em execução (database: regime_certo)

git clone https://github.com/GustavoSimao/Regime-Certo.git
cd regime-certo

./mvnw spring-boot:run

Servidor disponível em:

http://localhost:8080


📡 API
POST /analysis

Análise rápida de faturamento

Request

{
  "faturamento": 75000.00
}

Response

{
  "ideal": "Microempreendedor Individual (MEI)",
  "status": "OK",
  "mensagem": "Você atingiu 92,59% do limite de R$ 81000,00. Está dentro do permitido."
}
POST /enterprise

Cadastro de empresa

Request

{
  "nomeFantasia": "Padaria do João",
  "cnpj": "12.345.678/0001-90",
  "telefone": "27999998888",
  "email": "contato@padariadojoao.com.br",
  "atividade": "Comércio de alimentos",
  "localizacao": "Vitória, ES"
}

Response
201 Created


🗺️ Roadmap

Fase 1 — MVP (concluída)
Análise de faturamento com regime, status e mensagem
Cadastro de empresa com validações
Tratamento global de exceções

Fase 2 — Cadastro e autenticação
Confirmação de e-mail com token
Criptografia de senha com BCrypt

Fase 3 — Análise completa
Percentual exato do limite
Retorno do anexo do Simples Nacional
Integração com IA para análise de tendência
Endpoint separado para análise completa
Testes unitários no serviço de análise

Fase 4 — Contadores por localização
Integração com Google Maps Places API
Busca por contadores próximos
Retorno com dados relevantes e link do mapa

Fase 5 — Histórico de faturamento
Registro mensal por empresa
Endpoint de consulta por CNPJ
Gráfico de evolução com Chart.js
Projeção baseada em histórico e IA

Fase 6 — Qualidade e lançamento
Deploy (Railway ou Render)
Testes de integração
Termos de uso e política de dados
Licença MIT


📌 Observações
@CrossOrigin(origins = "*") está habilitado para desenvolvimento local
A regra de enquadramento usa o enum RegimeEnquadrado
Faturamento acima do teto do EPP é classificado como grande porte
Validações utilizam Bean Validation com tratamento global via @ControllerAdvice


📄 Licença

MIT License. Uso livre para estudo, modificação e contribuição.
