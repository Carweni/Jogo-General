# Jogo-General
Projeto de programação em Java do jogo General, referente à disciplina de Programação Orientada a Objetos.

# Introdução

General é um jogo de dados para dois ou mais jogadores. Para jogar General são necessários cinco dados comuns (hexaédricos) e uma cartela de marcação. O objetivo do jogo é marcar o maior número de pontos, através de algumas combinações de resultados nos dados.
A aplicação poderá executar n (indeterminadas) rodadas para os jogadores (humanos ou máquinas) participantes do Campeonato do Jogo General. Em cada rodada, cada jogador (humano ou máquina), por sua vez, joga os dados e, conforme o resultado obtido, marca a jogada prevista em sua cartela. Uma vez marcada, aquela jogada não poderá ser repetida pelo mesmo jogador até o final da rodada.

## Regras:

(1) Sendo 13 o número de jogadas possíveis e 13 o número máximo de linhas para cada coluna na cartela de marcaçã, uma rodada consiste de 13 jogadas para cada jogador.

(2) Cada jogador (humano ou máquina), em sua vez, tem apenas uma chance de arremessar os dados.

(3) O resultado obtido ao final do arremesso deve ser classificado, pelo próprio jogador, como uma das seguintes 13 possibilidades:

-Jogada de 1: um certo número de dados (de 0 a 5) marcando o número 1; sendo que a jogada vale mais pontos conforme a quantidade de dados que marcarem o número 1. Por exemplo: 1-1-1-4-5 vale 3 pontos.

-Jogadas de 2, 3, 4, 5 e 6: correspondentes à jogada de 1 para os demais números. Por exemplo: 3-3-4-4-5 vale 6 pontos se for considerada uma jogada de 3; ou 8 pontos se for considerada uma jogada de 4; ou ainda 5 pontos se for uma jogada de 5.

-Trinca (T): três dados marcando o mesmo número. Vale a soma dos 5 dados. Exemplo: 4-4-4-5-6 vale 23 pontos.

-Quadra (Q): quatro dados marcando o mesmo n´umero. Vale a soma dos 5 dados. Exemplo: 1-5-5-5-5 vale 21 pontos.

-Full-hand (F) ou Full-house: uma trinca e um par (exemplo: 2-2-2-6-6). Vale 25 pontos para qualquer combinação.

-Sequência alta (S+): 2-3-4-5-6. Vale 30 pontos.

-Sequência baixa (S-): 1-2-3-4-5. Vale 40 pontos.

-General (G): cinco dados marcando o mesmo n´umero (por exemplo: 4-4-4-4-4). Vale 50 pontos.

-Jogada aleatória (X) : qualquer combinação. Vale a soma dos 5 dados. Por exemplo: 1-4-4-5-6 vale 20 pontos.

(4) O resultado deverá ser mostrado na forma de cartela, na coluna do jogador e na linha correspondente à jogada. Aquela linha (e portanto aquela jogada) não poderá mais ser utilizada pelo jogador na mesma rodada.

(5) Se um determinado resultado não cumprir os requisitos para a jogada escolhida, o jogador zera a respectiva jogada. E ainda, se um determinado resultado não puder ser classificado como nenhuma das jogadas ainda restantes para aquele jogador, ele deverá escolher qual das jogadas restantes será descartada, marcando 0 (zero) para a jogada correspondente.

(6) Ao final de 13 rodadas, com a cartela toda preenchida, somam-se os valores de cada coluna, e o jogador que obtiver mais pontos será considerado o vencedor
