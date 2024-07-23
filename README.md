# Vaga: Desenvolvedor(a) Backend - Magazine Luiza


# Plataforma de Comunicação - Aplicação de Agendamento de Notificações

## Descrição do Projeto
Este projeto consiste na construção de uma aplicação que faz parte de uma plataforma de comunicação. A aplicação tem como objetivo principal gerenciar o agendamento de envio de notificações, permitindo aos usuários realizar agendamentos, consultar o status desses agendamentos e também cancelá-los conforme necessário.

## Funcionalidades Principais
A aplicação oferece as seguintes funcionalidades:

1. **Agendamento de Envio de Notificações:**
   - Permite aos usuários enviar solicitações para agendar o envio de notificações em datas e horários específicos.

2. **Consulta de Status de Agendamento:**
   - Permite aos usuários consultar o status atual de um agendamento de notificação para verificar se foi concluído, pendente ou cancelado.

3. **Cancelamento de Agendamento:**
   - Permite aos usuários cancelar um agendamento de notificação previamente agendado, caso seja necessário.

## Tecnologias Utilizadas
- Linguagem de Programação: Java
- Banco de Dados: Mysql
- Frameworks/Libraries: SpringBoot,Scheduled,JavaMailSender

## informações da lib
- Schedule: É utilizado para agendar automaticamente a execução de uma função em momentos específicos pelo sistema.
- JavaMailSender é utilizada para enviar e-mails através de sistemas Java..

## Instalação e Configuração
Para configurar e executar o projeto localmente, siga os passos abaixo:

1. **Clone o Repositório:**
   ```bash
   git clone https://github.com/Everton-GS/Desafio-Backend-da-Magalu.git
   cd nome-do-repositorio
   ```
   
   2.**Starta docker:**
   ```bash
   docker-compose up --build -d
   ```

   3.**SGBD:**
   ```bash
   login:root
   senha:mensagemService
   ```
   
