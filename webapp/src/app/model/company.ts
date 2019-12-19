import { boardOfDirectors } from './boardOfDirectors';
import { sector } from './sector';
import { stockExchange } from './stockExchange';

export interface company{
    id: number;
    companyCode: number;
    name: String;
    turnover: number;
    ceo: String;
    boardOfDirectorsList: boardOfDirectors[];
    listed: boolean;
    sector: sector;
    auboutCompany: String;
    stockExchangeList: stockExchange[];
}