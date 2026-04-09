# 🏢 Regime Certo — Simulador de Enquadramento Tributário

Sistema web para auxiliar empreendedores a identificar o melhor regime tributário com base no faturamento anual da empresa. (MVP - Produto Mínimo Viável. sistema posterior será mais completo)


## 📋 Sobre o Projeto

O **Regime Certo** é uma aplicação full-stack simples que recebe o faturamento anual de uma empresa e retorna:

- O **regime tributário ideal** (MEI, ME, EPP ou Grande Porte)
- O **status** do faturamento em relação ao teto do regime (OK, ALERTA ou EXCEDIDO)
- Uma **mensagem explicativa** para orientar o empreendedor


## 💼 Regimes Tributários e Limites

| Regime | Teto Anual |
|---|---|
| MEI — Microempreendedor Individual | R$ 81.000,00 |
| ME — Microempresa | R$ 360.000,00 |
| EPP — Empresa de Pequeno Porte | R$ 4.800.000,00 |
| Empresa de Grande Porte | Acima do EPP |


## 🚦 Status do Faturamento

| Status | Condição | Significado |
|---|---|---|
| ✅ OK | < 70% do teto | Faturamento confortável |
| ⚠️ ALERTA | Entre 70% e 100% do teto | Atenção ao limite |
| ❌ EXCEDIDO | > 100% do teto | Teto ultrapassado — procure um contador |



## 🛠️ Tecnologias

- **Backend:** Java 21 · Spring Boot 3.4.5 · Spring Web · Spring Data JPA
- **Banco de dados:** MySQL
- **Frontend:** HTML5, CSS, JavaScript



## 🚀 Como Executar

### Pré-requisitos

- Java 21
- Maven
- MySQL rodando localmente (banco: `regime_certo`)

### Backend
bash
# Clone o repositório
git clone https://github.com/GustavoSimao/Regime-Certo.git
cd regime-certo

# Execute com Maven
./mvnw spring-boot:run

O servidor sobe em http://localhost:8080


## 📡 API

### `POST /analise`

**Request:**
json
{
  "faturamento": 75000.00
}


**Response:**
json
{
  "ideal": "Microempreendedor Individual (MEI)",
  "status": "OK",
  "mensagem": "De acordo com seu faturamento atual, você não atingiu nem 70% do total ideal"
}


## 📌 Observações

- O projeto usa`@CrossOrigin(origins = "*") para permitir requisições do frontend local.
- A lógica de enquadramento é baseada nos tetos definidos no enum RegimeEnquadrado.
- Para faturamentos acima do teto do EPP, o sistema classifica como **Empresa de Grande Porte** e recomenda buscar um contador.
