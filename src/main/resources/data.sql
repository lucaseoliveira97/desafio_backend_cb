INSERT INTO BRANCHES (name, cnpj, city, uf,type,active ,registration_date) VALUES
    ('Branch1', '123123123123', 'Sao Paulo', 'SP', 'type1', TRUE, {ts '2021-09-17 18:47:52.69'}),
    ('Branch2', '456456456456', 'Rio de Janeiro', 'RJ', 'type2', TRUE, {ts '2022-01-20 10:27:32.59'});


INSERT INTO SELLERS (name, CPF_CNPJ, EMAIL, HIRING_TYPE,TASK_ID,BIRTH_DATE,BRANCH_ID ) VALUES
    ('Branch1', '123123123123', 'Sao Paulo', 'CLT', 'type1',  {ts '2021-09-17'}, 1),
    ('Branch2', '456456456456', 'Rio de Janeiro', 'Outsourcing', 'type2', {ts '2022-01-20'}, 2),
    ('Branch2', '456456456456', 'Rio de Janeiro', 'Pessoa Juridica', 'type2', {ts '2022-01-20'}, 2);
