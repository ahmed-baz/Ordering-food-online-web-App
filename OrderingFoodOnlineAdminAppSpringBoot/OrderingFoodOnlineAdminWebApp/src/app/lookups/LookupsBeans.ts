
export class CityBean {
    public id: Number;
    public name: string;
    public nameAr: string;
    public nameEn: string;
    constructor(
    ) { }
}

export class AreaBean {
    public id: Number;
    public name: string;
    public nameAr: string;
    public nameEn: string;
    public cityBean: CityBean;
    constructor() { };
}


