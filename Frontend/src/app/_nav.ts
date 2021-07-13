import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    icon: 'icon-speedometer',
    children: [
      {
        name: 'Nastri',
        url: '/nastri',
        icon: 'icon-list'
      },
      {
        name: 'Monitoraggio',
        url: '/monitoraggio',
        icon: 'icon-list'
      }
    ]
  }
];
